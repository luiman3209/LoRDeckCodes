package no.stelar7.lor.types;

import java.util.*;

public class LoRDeck
{
    private final Map<LoRCard, Integer> cards = new HashMap<>();
    
    /**
     * Adds a card to the deck
     */
    public void addCard(LoRCard card, int count)
    {
        if (count < 1)
        {
            throw new IllegalArgumentException("Count must be atleast 1");
        }
        
        cards.put(card, count);
    }
    
    /**
     * Removes a card from the deck
     */
    public void removeCard(LoRCard card)
    {
        cards.remove(card);
    }
    
    /**
     * Count the instances of a specified card in the deck
     */
    public int count(LoRCard card)
    {
        return cards.getOrDefault(card, 0);
    }
    
    /**
     * Removes all cards from the deck
     */
    public void clear()
    {
        cards.clear();
    }
    
    /**
     * Count the total amount of cards in the deck
     */
    public int deckSize()
    {
        return cards.values().stream().mapToInt(i -> i).sum();
    }
    
    public Map<LoRCard, Integer> getDeck()
    {
        return cards;
    }
    
    public String toPrettyString()
    {
        String       format = "%-7s : %1d";
        StringJoiner sj     = new StringJoiner("\n");
        
        this.cards.entrySet().stream()
                  .sorted(Comparator.comparing(e -> e.getKey().getCardCode()))
                  .forEachOrdered(e -> sj.add(String.format(format, e.getKey().getCardCode(), e.getValue())));
        
        return sj.toString();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        LoRDeck loRDeck = (LoRDeck) o;
        return Objects.equals(cards, loRDeck.cards);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(cards);
    }
    
    @Override
    public String toString()
    {
        return "LoRDeck{" +
               "cards=" + cards +
               '}';
    }
}
