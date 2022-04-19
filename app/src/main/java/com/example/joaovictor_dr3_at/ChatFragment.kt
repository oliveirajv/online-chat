package com.example.joaovictor_dr3_at

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar

class ChatFragment : Fragment() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    private lateinit var editTextMessageInput: EditText
    private lateinit var buttonSendMessage: Button
    private lateinit var viewModel: ChatViewModel
    private lateinit var listViewChatMessages: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.chat_fragment, container, false)
        viewModel = ViewModelProvider(this)[ChatViewModel::class.java]

        editTextMessageInput = view.findViewById(R.id.editTextMessageInput)
        buttonSendMessage = view.findViewById(R.id.buttonSendMessage)
        listViewChatMessages = view.findViewById(R.id.listViewChatMessages)

        viewModel.message.observe(viewLifecycleOwner) {
            if (!it.isNullOrBlank()) Snackbar.make(view, it, Snackbar.LENGTH_LONG).show()
        }

        viewModel.chat.observe(viewLifecycleOwner) {
            listViewChatMessages.adapter = ArrayAdapter(
                requireContext(), android.R.layout.simple_list_item_1, it
            )
            listViewChatMessages
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSendMessage.setOnClickListener {
            val userInputMessage = editTextMessageInput.text.toString()
            viewModel.insert(userInputMessage)
        }

        listViewChatMessages.setOnItemClickListener { _, _, messagePosition, _ ->
            viewModel.deleteMessage(messagePosition)
        }
    }
}