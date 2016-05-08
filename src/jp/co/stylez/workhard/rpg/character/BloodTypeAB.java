package jp.co.stylez.workhard.rpg.character;

/**
 * 血液型 ABの振る舞い
 * @author y-takahashi
 */
public interface BloodTypeAB {

	/**
	 * 攻撃します。
	 * @param target
	 */
	public void attack(AbstractCharacter target);

	/**
	 * 防御します。
	 */
	public void defence();

}
