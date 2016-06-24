package com.graduatedesign.hsl.yian.activitys;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.user.LoginService;
import com.graduatedesign.hsl.yian.domain.DoctorInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Mesogene on 3/18/16.
 */
public class UserInfoActivity extends FragmentActivity implements View.OnClickListener{
    MyApplication myApplication;
    private RelativeLayout user_image_layout;
    private RelativeLayout user_name_layout;
    private RelativeLayout user_sex_layout;
    private RelativeLayout user_mobile_layout;
    private RelativeLayout user_identity_layout;
    private RelativeLayout user_weixin_layout;
    private RelativeLayout user_area_layout;
    private TextView user_name;
    private TextView user_sex;
    private TextView user_mobile_num;
    private TextView user_identity;
    private TextView user_wechat;
    private TextView user_address;
    private ImageView user_image;
    private ImageView img_back;
    private ImageView img_save;
    private Button logout;
    private List<DoctorInfo> doctorInfos = new ArrayList<DoctorInfo>();
    private List<DoctorInfo> doctorInfo = new ArrayList<DoctorInfo>();
    RequestClient requestClient;
    Integer doctorId;
    private String doctor_name;
    private static final String IMAGE_FILE_NAME = "image.jpg";

    /** 请求码*/
    private static final int IMAGE_REQUEST_CODE = 0;
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int RESULT_REQUEST_CODE = 2;
    private LayoutInflater inflater;
    private Fragment fragment;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<DoctorInfo>> call = requestClient.getDoctorinfo("findbyname",doctor_name);
                doctorInfos = call.execute().body();
                handler.sendEmptyMessage(1);
            }catch (Exception e){
                Log.d("医生信息请求错误",e.getMessage());
            }
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what) {
                case 1:
                    user_name.setText(doctorInfos.get(0).getDoctorName());
                    user_image.setImageResource(R.drawable.yisheng1);
                    user_sex.setText(doctorInfos.get(0).getDoctorSex());
                    user_mobile_num.setText(doctorInfos.get(0).getDoctorPhoneNumber());
                    user_identity.setText(doctorInfos.get(0).getDoctorIdentity());
                    user_wechat.setText(doctorInfos.get(0).getDoctorWechat());
                    user_address.setText(doctorInfos.get(0).getDoctorAddress());
                    doctorId = doctorInfos.get(0).getDoctorId();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        myApplication = (MyApplication)getApplication();
        user_image_layout = (RelativeLayout)findViewById(R.id.user_image_layout);
        user_image_layout.setOnClickListener(this);
        user_name_layout = (RelativeLayout) findViewById(R.id.user_name_layout);
        user_name_layout.setOnClickListener(this);
        user_sex_layout = (RelativeLayout) findViewById(R.id.user_sex_layout);
        user_sex_layout.setOnClickListener(this);
        user_mobile_layout = (RelativeLayout) findViewById(R.id.user_mobile_layout);
        user_mobile_layout.setOnClickListener(this);
        user_identity_layout = (RelativeLayout) findViewById(R.id.user_identity_layout);
        user_identity_layout.setOnClickListener(this);
        user_weixin_layout = (RelativeLayout) findViewById(R.id.user_weixin_layout);
        user_weixin_layout.setOnClickListener(this);
        user_area_layout = (RelativeLayout) findViewById(R.id.user_area_layout);
        user_area_layout.setOnClickListener(this);
        user_image = (ImageView)findViewById(R.id.user_image);
        user_name = (TextView)findViewById(R.id.user_name);
        user_sex = (TextView)findViewById(R.id.user_sex);
        user_mobile_num = (TextView)findViewById(R.id.user_phone_number);
        user_identity = (TextView)findViewById(R.id.user_identity);
        user_wechat = (TextView)findViewById(R.id.user_weixin);
        user_address = (TextView)findViewById(R.id.user_area);
        img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        img_save = (ImageView)findViewById(R.id.img_save);
        img_save.setOnClickListener(this);
        logout = (Button)findViewById(R.id.login_out);
        logout.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        doctor_name = bundle.getString("name");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/doctorinfo/",gson);
        new Thread(getData).start();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.user_image_layout:

                AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT); //主题背景白色
                builder.setTitle("头像");

                final String[] image_choose = {"拍摄","从手机相册选择"};
                builder.setItems(image_choose, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 1://拍摄
                                Intent camera = new Intent();
                                camera.setType("image/*"); //设置文件类型
                                camera.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(camera, IMAGE_REQUEST_CODE);
                                break;
                            case 0:
                                Intent picture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                //判断存储卡是否可以用，可用进行存储
                                String state = Environment.getExternalStorageState();
                                if (state.equals(Environment.MEDIA_MOUNTED)) {
                                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                                    File file = new File(path, IMAGE_FILE_NAME);
                                    picture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                                }
                                startActivityForResult(picture, CAMERA_REQUEST_CODE);
                                break;
                        }
                    }
                });
                Dialog dialog = builder.create();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();
                break;
            case R.id.user_name_layout:
                Intent name = new Intent(UserInfoActivity.this,UserNameActivity.class);
                String username = user_name.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("str",username);
                name.putExtras(bundle);
                startActivityForResult(name, 4);
                break;
            case R.id.user_sex_layout:
                Intent sex = new Intent(UserInfoActivity.this,UserSexActivity.class);
                String usersex = user_sex.getText().toString();
                Bundle bundle1 = new Bundle();
                bundle1.putString("str",usersex);
                sex.putExtras(bundle1);
                startActivityForResult(sex,6);
                break;
            case R.id.user_mobile_layout:
                Intent mobile_num = new Intent(UserInfoActivity.this,UserMobileNumActivity.class);
                startActivityForResult(mobile_num,8);
                break;
            case R.id.user_identity_layout:
                Intent identity = new Intent(UserInfoActivity.this,UserIdentityActivity.class);
                String userIdentity = user_identity.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("str",userIdentity);
                identity.putExtras(bundle2);
                startActivityForResult(identity,10);
                break;
            case R.id.user_weixin_layout:

                break;
            case R.id.user_area_layout:

                break;
            case R.id.img_back:
                UserInfoActivity.this.finish();
                break;
            case R.id.img_save:
                String doc_name = user_name.getText().toString();
                String doc_sex = user_sex.getText().toString();
                String phone_number = user_mobile_num.getText().toString();
                String doc_identity = user_identity.getText().toString();
                String doc_wechat = user_wechat.getText().toString();
                String doc_address = user_address.getText().toString();
                doctorInfo.add(new DoctorInfo(doctorId,doc_name,doc_sex,phone_number,doc_identity,doc_wechat,doc_address));
                Call<List<DoctorInfo>> call = requestClient.updateDoctorinfo(doctorInfo);
                try{
                    call.enqueue(new Callback<List<DoctorInfo>>() {
                        @Override
                        public void onResponse(Call<List<DoctorInfo>> call, Response<List<DoctorInfo>> response) {

                        }

                        @Override
                        public void onFailure(Call<List<DoctorInfo>> call, Throwable t) {

                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.login_out:
                LoginService.clearLogin(this);
                myApplication.setLoginStatus("一键登录");
                myApplication.restartApplication();
            default:
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        //结果码
        switch (requestCode){
            case IMAGE_REQUEST_CODE:
                startPhotoZoom(data.getData());
                break;
            case CAMERA_REQUEST_CODE:
                //判断存储卡是否可以用，可用进行存储
                String state = Environment.getExternalStorageState();
                if(state.equals(Environment.MEDIA_MOUNTED)){
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                    File tempFile = new File(path,IMAGE_FILE_NAME);
                    startPhotoZoom(Uri.fromFile(tempFile));
                }else {
                    Toast.makeText(getApplicationContext(),"未找到存储卡，无法存储照片！",Toast.LENGTH_SHORT).show();
                }
                break;
            case RESULT_REQUEST_CODE: //图片完成缩放后
                if(data != null){
                    getImageToView(data);
                }
                break;
        }
        switch (resultCode){
            case 3:
                Bundle bundle = data.getExtras();
                String str = bundle.getString("str");
                user_name.setText(str);
                break;
            case 5:
                Bundle bundle1 = data.getExtras();
                String str1 = bundle1.getString("str");
                user_sex.setText(str1);
                break;
            case 7:
                break;
            case 9:
                Bundle bundle2 = data.getExtras();
                String str2 = bundle2.getString("str");
                user_identity.setText(str2);
                break;
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
    /*
    * 裁剪图片方法实现
    *@param uri
    * */
    public void startPhotoZoom(Uri uri){
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //设置裁剪
        intent.putExtra("crop","true");
        //aspectX aspectY 是宽高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY",1);
        //outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 340);
        intent.putExtra("outputY",340);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }
    /*
    * 保存裁剪之后的图片数据
    * @param picdata
    * */
    private void getImageToView(Intent data){
        Bundle extras = data.getExtras();
        if(extras != null){
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(this.getResources(),photo);
            user_image.setImageDrawable(drawable);
        }
    }
}
