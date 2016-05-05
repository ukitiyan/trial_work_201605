package jp.co.stylez.workhard.rpg.service;

import java.util.List;

import jp.co.stylez.workhard.rpg.character.AbstractHuman;
import jp.co.stylez.workhard.rpg.character.impl.Boss;

/**
 * patyとbossが戦闘するサービス
 * @author y-takahashi
 */
public interface CombatService {

	/**
	 * partyに攻撃指示した場合の処理
	 * @param party
	 * @param boss
	 */
	public void attack(List<AbstractHuman> party, Boss boss);

	/**
	 * partyに逃走指示した場合の処理
	 * @param party
	 * @param boss
	 */
	public void escape(List<AbstractHuman> party, Boss boss);

	/**
	 * partyに召喚指示した場合の処理
	 * @param party
	 * @param boss
	 */
	public void sage(List<AbstractHuman> party, Boss boss);

}
