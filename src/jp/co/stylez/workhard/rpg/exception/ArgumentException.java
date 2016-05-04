package jp.co.stylez.workhard.rpg.exception;

import jp.co.stylez.workhard.rpg.common.Constants;
import jp.co.stylez.workhard.rpg.common.Utils;

/**
 * 引数が不正な場合の例外です。
 * @author y-takahashi
 */
public class ArgumentException extends Exception {

	public ArgumentException() {
	}

	public ArgumentException(String message) {
		super(message);
		Utils.log(message, Constants.LogLevel.ERROR);
	}

}
