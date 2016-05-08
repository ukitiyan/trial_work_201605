package jp.co.stylez.workhard.rpg.character;

/**
 * 血液型 Bの振る舞い
 * @author y-takahashi
 */
public interface BloodTypeB {

	/**
	 * 攻撃します。
	 * @param target
	 */
	public void attack(AbstractCharacter target);

	/**
	 * 眠ります。
	 */
	public void sleep();

}
