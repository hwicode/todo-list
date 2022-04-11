package todo.list.controller;

import org.springframework.web.bind.annotation.*;
import todo.list.service.CardResponse;
import todo.list.service.CardSaveDto;
import todo.list.service.CardService;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/cards")
    public void save(CardSaveDto cardSaveDto) {
        cardService.save(cardSaveDto);
    }

    @GetMapping("/cards")
    public CardResponse getAllCards() {
        return cardService.findCollections();
    }

    @PatchMapping("/cards/{cardId}")
    public void modifyCard(@RequestBody CardModifyDto cardModifyDto) {
        cardService.modify(cardModifyDto);
    }
}
