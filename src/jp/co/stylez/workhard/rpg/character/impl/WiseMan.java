package jp.co.stylez.workhard.rpg.character.impl;

import jp.co.stylez.workhard.rpg.character.AbstractCharacter;
import jp.co.stylez.workhard.rpg.character.BloodTypeB;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterHp;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterName;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * 賢者
 * @author y-takahashi
 */
public class WiseMan extends AbstractCharacter implements BloodTypeB {

	public WiseMan() {
		super(DefaultCharacterName.WISE_MAN, DefaultCharacterHp.WISE_MAN);
	}
	public WiseMan(String name, int hp) {
		super(name, hp);
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeB#attack(jp.co.stylez.workhard.rpg.character.Human)
	 */
	@Override
	public void attack(AbstractCharacter target) {
		int powwer = 10000;
		if (System.currentTimeMillis() % 5 == 0) {
			Utils.log(this.getName() + "は、" + target.getName() + "に攻撃した。");
			target.damage(powwer);
			Utils.log("→ " + target.getName() + "の残りHPは" + target.getPositiveHp() + "です。");
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
