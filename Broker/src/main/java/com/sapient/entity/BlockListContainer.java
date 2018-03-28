package com.sapient.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import com.sapient.entity.Block;

@XmlRootElement(name = "blocks")
public class BlockListContainer {

	private List<Block> listBlock = new ArrayList<Block>();

	@XmlElement(name = "block")
	public List<Block> getBlockList() {
		return listBlock;
	}

	public void setBlockList(List<Block> listBlock) {
		this.listBlock = listBlock;
	}

	public BlockListContainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlockListContainer(List<Block> listBlock) {
		super();
		this.listBlock = listBlock;
	}

	@Override
	public String toString() {
		return "BlockList [listBlock=" + listBlock + "]";
	}

}
