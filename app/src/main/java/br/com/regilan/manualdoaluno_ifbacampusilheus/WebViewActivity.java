package br.com.regilan.manualdoaluno_ifbacampusilheus;

import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView web_view;
    SwipeRefreshLayout swipe_refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web_view = (WebView) findViewById(R.id.web_view);

        swipe_refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipe_refresh.setOnRefreshListener(atualizar);


        web_view.loadUrl("http://www.ilheus.ifba.edu.br/atendimento/app/app_definir_turma.php");

        //Habilitar JAVA SCRIPT
        WebSettings ws = web_view.getSettings();
        ws.setJavaScriptEnabled(true);

        //configurações para tratar os eventos da webView
        web_view.setWebViewClient(configuracoes);


    }



    //Configurações do WebView - quando carrega, quando finalizar o carregamento, etc...
    private WebViewClient configuracoes = new WebViewClient()
    {
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //coloca visibilidade no progressbar
            //progress_bar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            //tira animação do refreshing
            swipe_refresh.setRefreshing(false);
        }


        //Utilizado para carregar as páginas a partir do link na mesma activity
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

    };
    //método para recarregar a página com o deslize de cima para baixo
    SwipeRefreshLayout.OnRefreshListener atualizar = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            web_view.reload();
        }
    };
}
