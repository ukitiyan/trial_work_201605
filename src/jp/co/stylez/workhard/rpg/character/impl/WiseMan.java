package jp.co.stylez.workhard.rpg.character.impl;

import jp.co.stylez.workhard.rpg.character.AbstractHuman;
import jp.co.stylez.workhard.rpg.character.BloodTypeB;
import jp.co.stylez.workhard.rpg.common.Constants.CharacterHp;
import jp.co.stylez.workhard.rpg.common.Constants.CharacterName;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * 賢者
 * @author y-takahashi
 */
public class WiseMan extends AbstractHuman implements BloodTypeB {

	public WiseMan() {
		super(CharacterName.WISE_MAN, CharacterHp.WISE_MAN);
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeB#attack(jp.co.stylez.workhard.rpg.character.Human)
	 */
	@Override
	public void attack(AbstractHuman target) {
		int powwer = 10000;
		if (System.currentTimeMillis() % 5 == 0) {
			Utils.log(this.getName() + "は、" + target.getName() + "に攻撃した。");
			target.damage(powwer);
			Utils.log("→ " + target.getName() + "の残りHPは" + target.getHp() + "です。");
		} else {
			sleep();
		}
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeB#sleep()
	 */
	@Override
	public void sleep() {
		Utils.log(this.getName() + "は、眠った。");
	}



}
