package com.example.kavvka.web;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kavvka.web.service.MessageService;

@Controller
@RequestMapping("/kafka")
public class MessageController
{
	MessageService messageService;

	public MessageController(final MessageService messageService)
	{
		this.messageService = messageService;
	}

	@PostMapping("/postMessage")
	public ResponseEntity<String> postMessage()
	{
		messageService.postMessage();
		return ResponseEntity.status(OK).body("");
	}
}
