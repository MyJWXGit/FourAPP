package com.wd.health.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.wd.common.api.Constant;
import com.wd.health.APP;
import com.wd.health.APP_Login_Activity;

/**
 * @name Health
 * @class name：com.wd.health.wxapi
 * @class describe
 * @anthor 24673
 * @time 2019/12/18 17:09
 * @change
 * @chang time
 * @class describe
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //接收到分享以及登录的intent传递handleIntent方法，处理结果
        APP.api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        //登录回调
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) baseResp).code;
                //获取accesstoken
                Intent intent = new Intent(WXEntryActivity.this, APP_Login_Activity.class);
                intent.putExtra(Constant.WX_CODE, code);
                startActivity(intent);
                finish();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                Toast.makeText(this, "用户拒绝授权", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                Toast.makeText(this, "用户取消", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                finish();
                break;
        }

    }
}
