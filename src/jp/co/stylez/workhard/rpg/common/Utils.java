package jp.co.stylez.workhard.rpg.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.stylez.workhard.rpg.common.Constants.Command;
import jp.co.stylez.workhard.rpg.common.Constants.LogLevel;
import jp.co.stylez.workhard.rpg.exception.FirstArgumentException;
import jp.co.stylez.workhard.rpg.exception.SecondArgumentException;

/**
 * ユーティリティクラス。
 * @author y-takahashi
 */
public class Utils {

	/**
	 * 引数を検証します。
	 * @param args
	 * @throws FirstArgumentException
	 * @throws SecondArgumentException
	 */
	public static void validateCommand(String[] args) throws FirstArgumentException, SecondArgumentException {
		if (args == null || args.length == 0) {
			throw new FirstArgumentException("第1引数を指定してください。");
		}
		if (args.length < 2) {
			throw new SecondArgumentException("第2引数を指定してください。");
		}
		if (!Command.ATTACK.equals(args[0]) && !Command.ESCAPE.equals(args[0]) && !Command.SAGE.equals(args[0])) {
			throw new FirstArgumentException("第1引数が不正です。");
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(args[1]);
			sdf.format(new Date());
		} catch (IllegalArgumentException e) {
			throw new SecondArgumentException("第2引数が不正です。");
		}
	}

	/**
	 * ログ出力
	 * @param message
	 * @param level
	 */
	public static void log(String message, int level) {
		String prefix = null;
		if (level == LogLevel.ERROR) {
			prefix = "ERROR: ";
		} else {
			prefix = "INFO: ";
		}
		System.out.println(prefix + message);
	}

	/**
	 * ログ出力（INFO）
	 * @param message
	 */
	public static void log(String message) {
		log(message, LogLevel.INFO);
	}
}
