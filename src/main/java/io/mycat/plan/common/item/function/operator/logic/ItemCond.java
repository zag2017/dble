package io.mycat.plan.common.item.function.operator.logic;

import java.util.ArrayList;
import java.util.List;

import io.mycat.plan.common.item.FieldTypes;
import io.mycat.plan.common.item.Item;
import io.mycat.plan.common.item.function.primary.ItemBoolFunc;


public abstract class ItemCond extends ItemBoolFunc {
	protected boolean abort_on_null = true;
	List<Item> list;

	public ItemCond(List<Item> args) {
		super(args);
		list = new ArrayList<Item>();
		list.addAll(args);
	}

	public void add(Item item) {
		list.add(item);
	}

	public void add_at_head(Item item) {
		list.add(0, item);
	}

	public void add_at_head(List<Item> itemList) {
		list.addAll(0, itemList);
	}

	@Override
	public ItemType type() {
		return ItemType.COND_ITEM;
	}

	@Override
	public FieldTypes fieldType() {
		return FieldTypes.MYSQL_TYPE_LONGLONG;
	}

}