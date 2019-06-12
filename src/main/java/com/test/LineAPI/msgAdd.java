package com.test.LineAPI;

import static java.util.Collections.singletonList;

import java.util.ArrayList;
import java.util.List;

import com.linecorp.bot.model.message.ImagemapMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.imagemap.ImagemapArea;
import com.linecorp.bot.model.message.imagemap.ImagemapBaseSize;
import com.linecorp.bot.model.message.imagemap.MessageImagemapAction;


public class msgAdd {
	
	public List<Message> msgcheck(List<msgInfo> baseMsgList) {
		List<Message> LineMsgList=new ArrayList<Message>();
		while(!baseMsgList.isEmpty()) {
			if(baseMsgList.get(0).msgType=="text")
				LineMsgList.add(testmsg(baseMsgList.remove(0).msgcontent));
			else if(baseMsgList.get(0).msgType=="Image")
				LineMsgList.add(Imagemsg(baseMsgList.remove(0).msgcontent));
			else
				baseMsgList.remove(0);
		}
		return LineMsgList;
	}
	protected Message Imagemsg(String imgURL) {
        
        ImagemapMessage imagemapMessage = ImagemapMessage
                .builder()
                .baseUrl(imgURL)
                .altText("hoge")
                .baseSize(new ImagemapBaseSize(1040, 1040))
                .actions(singletonList(new MessageImagemapAction("hoge", new ImagemapArea(0, 0, 20, 20))))
                .build();
        
        return imagemapMessage;
	}
	protected Message testmsg(String text) {
		TextMessage textMessage = new TextMessage(text);
		return textMessage;
	}
}
