package com.example.security.web;

import com.example.security.item.Item;
import com.example.security.item.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

//    @GetMapping("/items")
//    public String listItems(Model model) {
//            model.addAttribute("items", itemService.getAllItem());
//        return "itemList";
//    }

    @GetMapping("/items")
    public String listItems(Model model,String q) {
        if(q != null) {
            model.addAttribute("items", itemService.findByQuery(q));
        }
        else{
            model.addAttribute("items", itemService.getAllItem());
        }
        return "itemList";
    }

    @GetMapping("/items/new")
    public String createItemForm(Model model){
        Item item = new Item();
        model.addAttribute("item", item);
        return "itemStore";
    }

    @PostMapping("/items")
    public String saveItem(@ModelAttribute("items") Item item) {
        itemService.saveItems(item);
        return "redirect:/items?savesuccess";
    }

    @GetMapping ("/items/edit/{id}")
    public String editItemForm(@PathVariable Long id, Model model){
        model.addAttribute("item", itemService.getItemById(id));
        return "itemStore";
    }

    @PostMapping("items/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute ("items") Item item, Model model){
        Item existingItem = itemService.getItemById(id);
        existingItem.setId(id);
        existingItem.setIndeks(item.getIndeks());
        existingItem.setName(item.getName());
        existingItem.setHourPrice(item.getHourPrice());

        // zapisz zmiany
        itemService.updateItem(existingItem);
        return "redirect:/items?updatesuccess";
    }

    @GetMapping("/items/{id}")
    public String deleteCLient(@PathVariable Long id){
        itemService.deleteItemById(id);
        return "redirect:/items?deletesuccess";
    }
}
