package kr.ac.kopo.menutest2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    LinearLayout linear;
    EditText etDegree;      // 각도 입력 EditText
    ImageView imageView;    // 이미지 표시 ImageView
    float imgRotation = 0;  // 이미지 누적 회전 각도

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linear = findViewById(R.id.main);
        etDegree = findViewById(R.id.et_degree);    // EditText 연결
        imageView = findViewById(R.id.imageView);   // ImageView 연결
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        super.onOptionsItemSelected(item);

        // 배경색 - 노랑
        if (item.getItemId() == R.id.item_yellow)
        {
            linear.setBackgroundColor(Color.YELLOW);
            return true;
        }
        // 배경색 - 카키
        else if (item.getItemId() == R.id.item_khaki)
        {
            linear.setBackgroundColor(Color.rgb(240, 230, 140));
            return true;
        }
        // 배경색 - 청색
        else if (item.getItemId() == R.id.item_blue)
        {
            linear.setBackgroundColor(Color.BLUE);
            return true;
        }
        // 그림 회전: EditText 각도값 읽어서 ImageView 누적 회전
        else if (item.getItemId() == R.id.item_img_rotate)
        {
            String degreeStr = etDegree.getText().toString();
            if (!degreeStr.isEmpty())
            {
                float degree = Float.parseFloat(degreeStr);
                imgRotation = imgRotation + degree;
                imageView.setRotation(imgRotation);
            }
            return true;
        }
        // 이미지 변경 - 한라산
        else if (item.getItemId() == R.id.item_hallasan)
        {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.hallasan);
            return true;
        }
        // 이미지 변경 - 추자도
        else if (item.getItemId() == R.id.item_chujado)
        {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.chujado);
            return true;
        }
        // 이미지 변경 - 범섬
        else if (item.getItemId() == R.id.item_beomseom)
        {
            item.setChecked(true);
            imageView.setImageResource(R.drawable.beomseom);
            return true;
        }

        return false;
    }
}