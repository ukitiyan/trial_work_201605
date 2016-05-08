package jp.co.stylez.workhard.rpg.common;

/**
 * 定数管理クラス
 * @author y-takahashi
 */
public class Constants {

	/**
	 * コマンドの定数
	 */
	public class Command {
		/** 攻撃 */
		public static final String ATTACK = "attack";
		/** 逃走 */
		public static final String ESCAPE = "escape";
		/** 召喚 */
		public static final String SAGE = "sage";
	}

	/**
	 * ログレベル
	 */
	public class LogLevel {
		/** 情報（デフォルト） */
		public static final int INFO = 1;
		/** エラー */
		public static final int ERROR = 3;
	}

	/**
	 * キャラクターのデフォルト名前の定義
	 */
	public class DefaultCharacterName {
		/** 勇者の名前 */
		public static final String BRAVE = "ゆうしゃ";
		/** 魔法使いの名前 */
		public static final String WITCH = "まほうつかい";
		/** 賢者の名前 */
		public static final String WISE_MAN = "けんじゃ";
		/** ボスの名前 */
		public static final String BOSS = "ぼす";
	}

	/**
	 * キャラクターのデフォルトHPの定義
	 */
	public class DefaultCharacterHp {
		/** 勇者のHP */
		public static final int BRAVE = 100;
		/** 魔法使いのHP */
		public static final int WITCH = 50;
		/** 賢者のHP */
		public static final int WISE_MAN = 0;
		/** ボスのHP */
		public static final int BOSS = 10000;
	}

}
