package jp.co.stylez.workhard.rpg.character;

/**
 * 人間のベースクラスです。
 * @author y-takahashi
 */
public abstract class AbstractHuman {

	private String name = null;
	private int hp = 0;

	public AbstractHuman(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return Math.abs(hp);
	}

	/**
	 * 引数で指定したpower分、自身のhpが減少します。
	 * @param power
	 */
	public void damage(int power) {
		this.hp -= power;
	}

	/**
	 * キャラクターが生存している場合、trueを返します。
	 * @return boolean
	 */
	public boolean isLife() {
		return this.hp > 0;
	}

}
