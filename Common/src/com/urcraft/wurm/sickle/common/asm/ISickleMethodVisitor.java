package com.urcraft.wurm.sickle.common.asm;

import org.objectweb.asm.MethodVisitor;

public interface ISickleMethodVisitor
{
    public String getName();
    public String getDesc();
    public String getSignature();
    public String getClassName();
    public MethodVisitor getParent();
    public int getAccess();
    public String[] getExceptions();
}
