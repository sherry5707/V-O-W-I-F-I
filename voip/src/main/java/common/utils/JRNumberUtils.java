package common.utils;

import android.content.Context;
import android.text.TextUtils;

import com.juphoon.rcs.JRClient;
import com.kinstalk.her.vowifivoip.JRCommonValue;
import com.kinstalk.her.vowifivoip.R;

/**
 * Created by Upon on 2018/2/27.
 */

public class JRNumberUtils {
    public static boolean isSelf(String number) {
        return TextUtils.equals(number, JRClient.getInstance().getCurLoginNumber());
    }

    private static boolean contactsIsDialable(char c) {
        return c == '+' || c == '*' || c == '#' || (c >= '0' && c <= '9');
    }

    public static String formatPhoneByCountryCode(String phone) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (phone.startsWith("00")) {
            sb.append("+");
            i = 2;
        } else if (!phone.startsWith("+")) {
            sb.append("+86");
        }
        for (; i < phone.length(); ++i) {
            char c = phone.charAt(i);
            if (contactsIsDialable(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    public static String formatPhoneWithoutCountryCode(String phone) {
//        if (phone != null && phone.startsWith("+86")) {
//
//        }
//    }

    public static String getStatMsg(int statCode, Context context) {
        String loginState = "";
        if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SEND_MSG) {
            loginState = context.getString(R.string.login_error_send_msg);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_AUTH_FAILED) {
            loginState = context.getString(R.string.login_error_auth_fail);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_INVALID_USER) {
            loginState = context.getString(R.string.login_error_invalid_user);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_TIMEOUT) {
            loginState = context.getString(R.string.login_error_timeout);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SERV_BUSY) {
            loginState = context.getString(R.string.login_error_srv_busy);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SERV_NOT_REACH) {
            loginState = context.getString(R.string.login_error_not_reach);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SRV_FORBIDDEN) {
            loginState = context.getString(R.string.login_error_srv_forbidden);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SRV_UNAVAIL) {
            loginState = context.getString(R.string.login_error_srv_unavailable);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_DNS_QRY) {
            loginState = context.getString(R.string.login_error_dns_qry);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_NETWORK) {
            loginState = context.getString(R.string.login_error_network);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_INTERNAL) {
            loginState = context.getString(R.string.login_error_internal);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_REJECTED) {
            loginState = context.getString(R.string.login_error_rejected);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_OTHER) {
            loginState = context.getString(R.string.login_error_other);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_SIP_SESS) {
            loginState = context.getString(R.string.login_error_sip_sess);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_UNREG) {
            loginState = context.getString(R.string.login_error_unreg);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_INVALID_ADDR) {
            loginState = context.getString(R.string.login_error_invalid_addr);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_NOT_FOUND) {
            loginState = context.getString(R.string.login_error_not_found);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_AUTH_REJECT) {
            loginState = context.getString(R.string.login_error_auth_reject);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_ID_NOT_MATCH) {
            loginState = context.getString(R.string.login_error_not_match);
        } else if (statCode == JRCommonValue.MTC_CLI_REG_ERR_USER_NOT_EXIST) {
            loginState = context.getString(R.string.login_error_user_not_exist);
        }
//        else {
//            loginState = context.getString(R.string.logouted);
//        }
        return loginState;
    }
}
