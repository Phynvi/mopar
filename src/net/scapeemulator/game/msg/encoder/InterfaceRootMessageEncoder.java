package net.scapeemulator.game.msg.encoder;

import io.netty.buffer.ByteBufAllocator;
import net.scapeemulator.game.msg.MessageEncoder;
import net.scapeemulator.game.msg.impl.inter.InterfaceRootMessage;
import net.scapeemulator.game.net.game.DataOrder;
import net.scapeemulator.game.net.game.DataTransformation;
import net.scapeemulator.game.net.game.DataType;
import net.scapeemulator.game.net.game.GameFrame;
import net.scapeemulator.game.net.game.GameFrame.Type;
import net.scapeemulator.game.net.game.GameFrameBuilder;

public final class InterfaceRootMessageEncoder extends MessageEncoder<InterfaceRootMessage> {

	public InterfaceRootMessageEncoder() {
		super(InterfaceRootMessage.class);
	}

	@Override
	public GameFrame encode(ByteBufAllocator alloc, InterfaceRootMessage message) {
		GameFrameBuilder builder = new GameFrameBuilder(alloc, 145, Type.FIXED);
		builder.put(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD, message.getId());
		builder.put(DataType.BYTE, DataTransformation.ADD, 0);
		builder.put(DataType.SHORT, DataOrder.LITTLE, DataTransformation.ADD, 0);
		return builder.toGameFrame();
	}

}
