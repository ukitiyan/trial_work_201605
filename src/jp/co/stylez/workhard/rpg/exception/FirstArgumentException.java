package jp.co.stylez.workhard.rpg.exception;

/**
 * 第1引数が不正な場合の例外です。
 * @author y-takahashi
 */
public class FirstArgumentException extends ArgumentException {

	public FirstArgumentException() {
	}

	public FirstArgumentException(String message) {
		super(message);
	}

}
