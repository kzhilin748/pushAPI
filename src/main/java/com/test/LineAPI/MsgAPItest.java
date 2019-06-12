package com.test.LineAPI;

import java.util.concurrent.ExecutionException;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.test.model.PushAPIInfo;

public class MsgAPItest {
	public void PushAPItest(PushAPIInfo Info) {
		LineMessagingClient client = LineMessagingClient
		        .builder(Info.getchannelToken()
		        		)
		        .build();
//		//
//		TextMessage textMessage = new TextMessage("TEst");
//		PushMessage pushMessage = new PushMessage(
//				Info.getUserID(),
//				textMessage);
//		client.pushMessage(pushMessage);
//		//
		while(!Info.getMessagelist().isEmpty()) {
//			TextMessage textMessage = new TextMessage(Info.getMessagelist().remove(index));
			PushMessage pushMessage = new PushMessage(
					Info.getUserID(),
					Info.getMessagelist().remove(0));

			BotApiResponse botApiResponse;
			try {
			    botApiResponse = client.pushMessage(pushMessage).get();
			} catch (InterruptedException | ExecutionException e) {
			    e.printStackTrace();
			    return;
			}

			System.out.println(botApiResponse);
		}

	}

}
