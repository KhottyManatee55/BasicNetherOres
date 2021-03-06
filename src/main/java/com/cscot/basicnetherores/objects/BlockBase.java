package com.cscot.basicnetherores.objects;

import com.cscot.basicnetherores.BasicNetherOres;
import com.cscot.basicnetherores.lists.BlockList;
import com.cscot.basicnetherores.lists.ItemList;
import com.cscot.basicnetherores.util.handler.ConfigHandler;
import com.cscot.basicnetherores.util.handler.RegisteryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

//This class takes the BlockList blocks and creates them with specific properties
public class BlockBase extends Block
{
    private String name;

    public BlockBase(String name)
    {
        super(Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL));

        setRegistryName(BasicNetherOres.modid, name);

        ItemList.items.add(new BlockItem(this.getBlock(), new Item.Properties().group(BasicNetherOres.bnoItemGroup)).setRegistryName(RegisteryHandler.RegistryEvents.location(name)));

        BlockList.blocks.add(this);
    }
}
