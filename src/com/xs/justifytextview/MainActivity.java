package com.xs.justifytextview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.main_tv);
		// �˴�Ϊ����JustifyTextView����,ʹ�÷�����ԭ��TextView��ͬ
		tv.setText(getAssetsString(this, Messages.getString("MainActivity.0"))); //$NON-NLS-1$
	}

	public String getAssetsString(Context context, String fileName)
	{
		StringBuffer sb = new StringBuffer();
		// ��������ѡ�����
		try
		{
			AssetManager am = context.getAssets();
			InputStream in = am.open(fileName);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null)
			{
				line += (Messages.getString("MainActivity.1")); //$NON-NLS-1$
				sb.append(line);
			}
			reader.close();
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}

}
