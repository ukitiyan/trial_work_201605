package jp.co.stylez.workhard.rpg;

import static jp.co.stylez.workhard.rpg.common.Utils.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractCharacter;
import jp.co.stylez.workhard.rpg.character.impl.Boss;
import jp.co.stylez.workhard.rpg.character.impl.Brave;
import jp.co.stylez.workhard.rpg.character.impl.Witch;
import jp.co.stylez.workhard.rpg.common.Constants;
import jp.co.stylez.workhard.rpg.common.Constants.Command;
import jp.co.stylez.workhard.rpg.exception.ArgumentException;
import jp.co.stylez.workhard.rpg.service.CombatService;
import jp.co.stylez.workhard.rpg.service.impl.CombatServiceImpl;

/**
 * 戦闘ジョブ起動用ブートストラップです。
 * @author y-takahashi
 */
public class CombatJob {

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

		// コマンド設定
		String command = args[0];
		String dateFormat = args[1];
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		// キャラクター設定
		List<AbstractCharacter> party = Arrays.asList(new Brave("ゆうしゃ", 100), new Witch("まほうつかい", 50));
		Boss boss = new Boss("ぼす", 10000);

		// 戦闘開始
		log(sdf.format(new Date()) + ": 戦闘が開始されました。");

		CombatService combatService = new CombatServiceImpl();
		if (Command.ATTACK.equals(command)) {
			combatService.attack(party, boss);
		} else if (Command.ESCAPE.equals(command)) {
			combatService.escape(party, boss);
		} else if (Command.SAGE.equals(command)) {
			combatService.sage(party, boss);
		}

		log(sdf.format(new Date()) + ": 戦闘が終了しました。");

	}

}
