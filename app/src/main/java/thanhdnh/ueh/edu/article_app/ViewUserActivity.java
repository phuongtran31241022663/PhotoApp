package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewUserActivity extends AppCompatActivity {
  ImageView iv_user_profile;
  TextView tv_user_name, tv_user_bio;
  Button btn_back;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_user);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    iv_user_profile = findViewById(R.id.iv_user_profile);
    tv_user_name = findViewById(R.id.tv_user_name);
    tv_user_bio = findViewById(R.id.tv_user_bio);
    btn_back = findViewById(R.id.btn_back);

    int id = (int) getIntent().getLongExtra("id", 0);
    User user = UserData.getUserFromId(id);

    if (user != null) {
      if (user.getUrl_profile() != null && !user.getUrl_profile().isEmpty()) {
        Picasso.get().load(user.getUrl_profile()).resize(400, 500).centerCrop().into(iv_user_profile);
      }
      tv_user_name.setText(user.getUname());
      tv_user_bio.setText(user.getShort_bio());
    }

    btn_back.setOnClickListener(v -> finish());
  }
}
