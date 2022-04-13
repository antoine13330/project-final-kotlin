package com.example.speachmyapp.ui.webview

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.speachmyapp.databinding.FragmentWebviewBinding
import com.google.android.material.snackbar.Snackbar


/**
 * A simple [Fragment] subclass.
 * Use the [Webview.newInstance] factory method to
 * create an instance of this fragment.
 */
class Webview : Fragment() {
    // -- for view binding --
    private var _binding: FragmentWebviewBinding? = null
    /* _binding props getter */
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        // -- for view binding --
        _binding = FragmentWebviewBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // ----------------------

        // -- init web view --
        binding.webView.webViewClient = WebViewController()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://www.ynov.com/")
        // -------------------

        // -- set event listeners --
        binding.searchButton.setOnClickListener{
            val urlToSearch = binding.inputSearchUrl.text.toString()
            // regex found on https://ihateregex.io/expr/url/ and modified to match even non https/http/www url
            val regex = "(https?:\\/\\/(www\\.)?)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&\\/\\/=]*)S".toRegex();
            if (urlToSearch matches regex) {
                binding.webView.loadUrl(urlToSearch)
                Snackbar.make(it, "WebView is loading", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } else {
                Snackbar.make(it, "Invalid url", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }



        }
        // ------------------------

        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}

class WebViewController : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }
}