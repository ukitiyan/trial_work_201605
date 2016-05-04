package jp.co.stylez.workhard.rpg;

import static jp.co.stylez.workhard.rpg.common.Utils.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractHuman;
import jp.co.stylez.workhard.rpg.character.BloodTypeA;
import jp.co.stylez.workhard.rpg.character.BloodTypeB;
import jp.co.stylez.workhard.rpg.character.impl.Boss;
import jp.co.stylez.workhard.rpg.character.impl.Brave;
import jp.co.stylez.workhard.rpg.character.impl.Witch;
import jp.co.stylez.workhard.rpg.common.Constants;
import jp.co.stylez.workhard.rpg.common.Constants.Command;
import jp.co.stylez.workhard.rpg.exception.ArgumentException;

/**
 * ジョブ起動用ブートストラップです。
 * @author y-takahashi
 */
public class JobLauncher {

	/**
	 * ジョブを起動します。
	 * @param args コマンドの引数<br>
	 * 第1引数: {@link Constants.Command}の何れかの行動を指定します。 <br>
	 * 第2引数: {@link SimpleDateFormat}に指定可能なプログラムで使う時間フォーマットを指定します。
	 */
	public static void main(String[] args) {

		try {
			validateCommand(args);
		} catch (ArgumentException e) {
			e.printStackTrace();
			return;
		}

		String command = args[0];
		String dateFormat = args[1];

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		log(sdf.format(new Date()) + ": 戦闘が開始されました。");

		List<AbstractHuman> party = Arrays.asList(new Brave(), new Witch());
		Boss boss = new Boss();

		if (Command.ATTACK.equals(command)) {
			attack(party, boss);
		} else if (Command.ESCAPE.equals(command)) {
			escape(party, boss);
		} else if (Command.SAGE.equals(command)) {
			List<AbstractHuman> partyWithWiseMan = new ArrayList<AbstractHuman>();
			partyWithWiseMan.addAll(party);
			for (AbstractHuman character : party) {
				if (character instanceof Witch) {
					partyWithWiseMan.add(((Witch) character).sage());
				}
			}
			attack(partyWithWiseMan, boss);
		}

		log(sdf.format(new Date()) + ": 戦闘が終了しました。");

	}

	protected static void attack(List<AbstractHuman> party, Boss boss) {
		int count = 1;
		while (true) {
			// 味方のターン
			for (AbstractHuman character : party) {
				if (character instanceof BloodTypeA) {
					((BloodTypeA) character).attack(boss);
					if (!boss.isLife()) {
						log("ボスが倒れた。");
						return;
					}
				}
				if (character instanceof BloodTypeB) {
					((BloodTypeB) character).attack(boss);
					if (!boss.isLife()) {
						log("ボスが倒れた。");
						return;
					}
				}
			}
			// ボスのターン
			if (count % 2 == 0) {
				boss.endlessAttack(party);
				return;
			} else {
				boss.defence();
			}
			++count;
		}
	}
	protected static void escape(List<AbstractHuman> party, Boss boss) {
		int count = 1;
		while (true) {
			// 味方のターン
			boolean allEscape = true;
			for (AbstractHuman character : party) {
				if (!((BloodTypeA) character).escape()) {
					allEscape = false;
				}
			}
			if (allEscape) {
				log("全員の逃走が成功した。");
				return;
			}
			// ボスのターン
			if (count % 2 == 0) {
				boss.endlessAttack(party);
				return;
			} else {
				boss.defence();;
			}
			++count;
		}
	}

}
