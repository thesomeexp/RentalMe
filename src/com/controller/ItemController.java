package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pojo.Item;
import com.pojo.User;
import com.service.IitemService;
import com.util.Commons;
import com.util.CommonsState;

@Controller
public class ItemController {

    @Autowired
    private IitemService iitemService;
    
//    添加物品, 添加完返回到物品详情页面
    @RequestMapping(value = "addItem", method = RequestMethod.POST)
    public String addItem(Item item, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user"); 
        Item newItem = new Item();
        System.out.println(item.toString());
        newItem.setUid(user.getId());
        newItem.setCid(item.getCid());
        newItem.setTitle(item.getTitle());
        newItem.setContact(item.getContact());
        newItem.setBasepayment(item.getBasepayment());
        newItem.setCounttype(item.getCounttype());
        newItem.setMintime(item.getMintime());
        newItem.setMaxtime(item.getMaxtime());
        newItem.setOvertimemoney(item.getOvertimemoney());
        newItem.setDeposit(item.getDeposit());
        newItem.setRenewable(item.getRenewable());
        newItem.setRentalstate(CommonsState.ITEM_STATE_ENABLE);
        int state = iitemService.insert(newItem);
        if (state != 1) {
            model.addAttribute("msg", Commons.INSERT_FAIL);
            return "/error";
        }
        return "redirect:/itemDetailPage/" + newItem.getId();
    }
    
    
    
}
