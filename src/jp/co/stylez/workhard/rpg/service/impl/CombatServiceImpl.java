package jp.co.stylez.workhard.rpg.service.impl;

import static jp.co.stylez.workhard.rpg.common.Utils.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractCharacter;
import jp.co.stylez.workhard.rpg.character.BloodTypeA;
import jp.co.stylez.workhard.rpg.character.BloodTypeB;
import jp.co.stylez.workhard.rpg.character.impl.Boss;
import jp.co.stylez.workhard.rpg.character.impl.Witch;
import jp.co.stylez.workhard.rpg.service.CombatService;

/**
 * {@link CombatService} の実装
 * @author y-takahashi
 */
public class CombatServiceImpl implements CombatService {

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.service.CombatService#attack(java.util.List, jp.co.stylez.workhard.rpg.character.impl.Boss)
	 */
	@Override
	public void attack(List<AbstractCharacter> party, Boss boss) {
		int count = 1;
		while (true) {
			// 味方のターン
			for (AbstractCharacter character : party) {
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

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.service.CombatService#escape(java.util.List, jp.co.stylez.workhard.rpg.character.impl.Boss)
	 */
	@Override
	public void escape(List<AbstractCharacter> party, Boss boss) {
		int count = 1;
		while (true) {
			// 味方のターン
			boolean allEscape = true;
			for (AbstractCharacter character : party) {
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

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.service.CombatService#sage(java.util.List, jp.co.stylez.workhard.rpg.character.impl.Boss)
	 */
	@Override
	public void sage(List<AbstractCharacter> party, Boss boss) {
		List<AbstractCharacter> partyWithWiseMan = new ArrayList<AbstractCharacter>();
		partyWithWiseMan.addAll(party);
		// 魔法使いが召喚
		for (AbstractCharacter character : party) {
			if (character instanceof Witch) {
				partyWithWiseMan.add(((Witch) character).sage());
			}
		}
		// 戦闘
		attack(partyWithWiseMan, boss);
	}

}
