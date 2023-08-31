package com.example.security.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItem(){
        return itemRepository.findAll();
    }

    public Item saveItems(Item item){
        return itemRepository.save(item);
    }

    public Item getItemById(Long id){
        return itemRepository.findById(id).get();
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public void deleteItemById(Long id){
        itemRepository.deleteById(id);
    }

    public List<Item> findByQuery(String q) {
        return itemRepository.findAllByIndeksContainsIgnoreCaseOrNameContainsIgnoreCaseOrHourPriceContainsIgnoreCase(q, q, q)
                .stream()
                .collect(Collectors.toList());
    }

    public long getCount() {
        return itemRepository.count();
    }
}
