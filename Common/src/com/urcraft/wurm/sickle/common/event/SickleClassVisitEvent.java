package com.urcraft.wurm.sickle.common.event;

import org.objectweb.asm.ClassVisitor;

public class SickleClassVisitEvent
{
    public String[] interfaces;
    public String superName;
    public String signature;
    public ClassVisitor visitor;
    public String className;

    public SickleClassVisitEvent(ClassVisitor visitor, String name, String signature, String superName, String[] interfaces)
    {
        this.className = name;
        this.visitor = visitor;
        this.signature = signature;
        this.superName = superName;
        this.interfaces = interfaces;
    }
}
