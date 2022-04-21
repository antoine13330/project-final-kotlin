package com.example.speachmyapp.ui.webview

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.speachmyapp.databinding.FragmentWebviewBinding
import com.google.android.material.snackbar.Snackbar



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

            if (!URLUtil.isValidUrl(urlToSearch))
                Snackbar.make(it, "Please enter a valid url (start with '(http|https)://' )", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            else
                binding.webView.loadUrl(urlToSearch)

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