package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Regilan on 27/07/2017.
 */

public class GaleriaImagensAdapter extends PagerAdapter {

    private Context context;
   private int[] imagens = new int[] { R.drawable.fotos_app_1, R.drawable.fotos_app_2, R.drawable.fotos_app_3,R.drawable.fotos_app_4,R.drawable.fotos_app_5 };

    GaleriaImagensAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup pager, int position, Object object) {
        ((ViewPager) pager).removeView((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup pager, int position) {
        ImageView imagem = new ImageView(context);
        imagem.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imagem.setImageResource(imagens[position]);
        ((ViewPager) pager).addView(imagem, 0);
        return imagem;
    }
}
