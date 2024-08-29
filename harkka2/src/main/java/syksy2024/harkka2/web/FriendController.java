package syksy2024.harkka2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import syksy2024.harkka2.domain.Friend;

@Controller
public class FriendController {

    private static List<Friend> friendList = new ArrayList<>();

	static {
		friendList.add(new Friend("kalevi", "Golf"));
		friendList.add(new Friend("saxon", "letku"));
		friendList.add(new Friend("darn", "donkus"));

	}

    @GetMapping("/friendList")
	public String showFriends(Model model) {
		System.out.println("friends...");
		model.addAttribute("friends", friendList);
		return "friendList";
	}

    @PostMapping("addFriend")
	public String addFriend(Friend friend) {
		System.out.println("AAAA : " + friend);
		friendList.add(friend);
		return "redirect:/friendList";
	}

    @GetMapping("/addFriend")
	public String newFriendInfo(Model model) {
		// insert list to model Key-Value
		model.addAttribute("friend", new Friend());
		return "addFriend";
	}

}
