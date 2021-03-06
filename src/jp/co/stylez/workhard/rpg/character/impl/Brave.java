package jp.co.stylez.workhard.rpg.character.impl;

import jp.co.stylez.workhard.rpg.character.AbstractCharacter;
import jp.co.stylez.workhard.rpg.character.BloodTypeA;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterHp;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterName;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * 勇者
 * @author y-takahashi
 */
public class Brave extends AbstractCharacter implements BloodTypeA {

	public Brave() {
		super(DefaultCharacterName.BRAVE, DefaultCharacterHp.BRAVE);
	}
	public Brave(String name, int hp) {
		super(name, hp);
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeA#attack(jp.co.stylez.workhard.rpg.character.Human)
	 */
	@Override
	public void attack(AbstractCharacter target) {
		int powwer = 50;
		if (target instanceof Boss && ((Boss) target).isDefence()) {
			powwer = powwer / 2;
		}
		Utils.log(this.getName() + "は、" + target.getName() + "に攻撃した。");
		target.damage(powwer);
		Utils.log("→ " + target.getName() + "の残りHPは" + target.getPositiveHp() + "です。");
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeA#escape()
	 */
	@Override
	public boolean escape() {
		boolean isSuccess = System.currentTimeMillis() % 2 == 0;
		if (isSuccess) {
			Utils.log(this.getName() + "は、逃走に成功した。");
		} else {
			Utils.log(this.getName() + "は、逃走に失敗した。");
		}
		return isSuccess;
	}


}
