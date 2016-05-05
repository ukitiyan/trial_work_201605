package jp.co.stylez.workhard.rpg.character.impl;

import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractHuman;
import jp.co.stylez.workhard.rpg.character.BloodTypeAB;
import jp.co.stylez.workhard.rpg.common.Constants.CharacterHp;
import jp.co.stylez.workhard.rpg.common.Constants.CharacterName;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * ボス
 * @author y-takahashi
 */
public class Boss extends AbstractHuman implements BloodTypeAB {

	private boolean defence = false;

	public Boss() {
		super(CharacterName.BOSS, CharacterHp.BOSS);
	}

	/* (非 Javadoc)
	 * @see jp.co.stylez.workhard.rpg.character.BloodTypeAB#attack(jp.co.stylez.workhard.rpg.character.Human)
	 */
	@Override
	public void attack(AbstractHuman target) {
		int powwer = 50;
		Utils.log(this.getName() + "は、" + target.getName() + "に攻撃した。");
		this.defence = false;
		target.damage(powwer);
		Utils.log("→ " + target.getName() + "の残りHPは" + target.getHp() + "です。");
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
	public void endlessAttack(List<AbstractHuman> targets) {
		Utils.log(this.getName() + "は、連続攻撃を開始した。");
		for (AbstractHuman target : targets) {
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
