package com.crossoverjie.netty.server.learning.decoder;

import com.crossoverjie.netty.server.learning.pojo.CustomProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Function: 解码信息
 *
 * @author crossoverJie
 *         Date: 17/05/2018 18:34
 * @since JDK 1.8
 */
public class CustomDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        long header = in.readLong() ;
        byte[] bytes = new byte[in.readableBytes()] ;
        in.readBytes(bytes) ;
        String content = new String(bytes) ;

        CustomProtocol customProtocol = new CustomProtocol() ;
        customProtocol.setHeader(header);
        customProtocol.setContent(content) ;
        out.add(customProtocol) ;

    }
}
