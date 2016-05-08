package jp.co.stylez.workhard.rpg.character;

/**
 * 血液型 Aの振る舞い
 * @author y-takahashi
 */
public interface BloodTypeA {

	/**
	 * 攻撃します。
	 * @param target
	 */
	public void attack(AbstractCharacter target);

	/**
	 * 逃走を試みて成功の場合、trueを返します。
	 * @return boolean
	 */
	public boolean escape();

}
