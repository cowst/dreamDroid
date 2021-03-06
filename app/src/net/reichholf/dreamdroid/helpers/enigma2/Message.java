/* © 2010 Stephan Reichholf <stephan at reichholf dot net>
 * 
 * Licensed under the Create-Commons Attribution-Noncommercial-Share Alike 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

package net.reichholf.dreamdroid.helpers.enigma2;

import java.util.ArrayList;

import net.reichholf.dreamdroid.helpers.ExtendedHashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author sreichholf
 *
 */
public class Message extends SimpleResult {
	public static final String KEY_TEXT = "message";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TIMEOUT = "timeout";	
	public static final String MESSAGE_TYPE_WARNING = "1";
	public static final String MESSAGE_TYPE_INFO = "2";
	public static final String MESSAGE_TYPE_ERROR = "3";
	
	public static ArrayList<NameValuePair> getParams(ExtendedHashMap message){
		ArrayList<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("text", message.getString(KEY_TEXT)));
		params.add(new BasicNameValuePair("type", message.getString(KEY_TYPE)));
		params.add(new BasicNameValuePair("timeout", message.getString(KEY_TIMEOUT)));
		
		return params;
	}
}
