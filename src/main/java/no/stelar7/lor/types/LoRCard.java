package no.stelar7.lor.types;

import no.stelar7.lor.utils.Utilities;

import java.util.Objects;

public class LoRCard
{
    private final int        set;
    private final LoRFaction faction;
    private final int        id;
    
    
    public LoRCard(String cardCode)
    {
        this(cardCode.substring(0, 2), cardCode.substring(2, 4), cardCode.substring(4, 7));
    }
    
    public LoRCard(String setString, String factionString, String numberString)
    {
        this(Integer.parseInt(setString), LoRFaction.fromCode(factionString), Integer.parseInt(numberString));
    }
    
    public LoRCard(int set, LoRFaction faction, int id)
    {
        this.set = set;
        this.faction = faction;
        this.id = id;
    }
    
    public String getCardCode()
    {
        return Utilities.padLeft(String.valueOf(set), "0", 2) + faction.getShortCode() + Utilities.padLeft(String.valueOf(id), "0", 3);
    }
    
    public int getSet()
    {
        return set;
    }
    
    public LoRFaction getFaction()
    {
        return faction;
    }
    
    public int getId()
    {
        return id;
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
        LoRCard loRCard = (LoRCard) o;
        return set == loRCard.set &&
               id == loRCard.id &&
               faction == loRCard.faction;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(set, faction, id);
    }
    
    @Override
    public String toString()
    {
        return "LoRCard{" +
               "set=" + set +
               ", faction=" + faction +
               ", id=" + id +
               '}';
    }
}
