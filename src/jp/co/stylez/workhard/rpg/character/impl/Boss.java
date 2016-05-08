package jp.co.stylez.workhard.rpg.character.impl;

import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractCharacter;
import jp.co.stylez.workhard.rpg.character.BloodTypeAB;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterHp;
import jp.co.stylez.workhard.rpg.common.Constants.DefaultCharacterName;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * ボス
 * @author y-takahashi
 */
public class Boss extends AbstractCharacter implements BloodTypeAB {

	private boolean defence = false;

	public Boss() {
		super(DefaultCharacterName.BOSS, DefaultCharacterHp.BOSS);
	}
	public Boss(String name, int hp) {
		super(name, hp);
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeAB#attack(jp.co.stylez.workhard.rpg.character.Human)
	 */
	@Override
	public void attack(AbstractCharacter target) {
		int powwer = 50;
		Utils.log(this.getName() + "は、" + target.getName() + "に攻撃した。");
		this.defence = false;
		target.damage(powwer);
		Utils.log("→ " + target.getName() + "の残りHPは" + target.getPositiveHp() + "です。");
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeAB#defence()
	 */
	@Override
	public void defence() {
		Utils.log(this.getName() + "は、防御した。");
		this.defence = true;
	}

	/**
	 * 引数で渡された全ての相手が倒れるまで攻撃します。
	 * @param target
	 */
	public void endlessAttack(List<AbstractCharacter> targets) {
		Utils.log(this.getName() + "は、連続攻撃を開始した。");
		for (AbstractCharacter target : targets) {
			while (true) {
				attack(target);
				if (!target.isLife()) {
					Utils.log(target.getName() + "は、倒れた。");
					break;
				}
			}
		}
	}

	public boolean isDefence() {
		return defence;
	}

}
