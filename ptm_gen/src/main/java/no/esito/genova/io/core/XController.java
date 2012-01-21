package no.esito.genova.io.core;

import no.esito.genova.io.classmodel.XAssociation;
import no.esito.genova.io.classmodel.XAttribute;
import no.esito.genova.io.classmodel.XClass;
import no.esito.genova.io.classmodel.XConverter;
import no.esito.genova.io.classmodel.XUserType;
import no.esito.genova.io.classmodel.XEnumerator;
import no.esito.genova.io.classmodel.XGeneralization;
import no.esito.genova.io.classmodel.XGroup;
import no.esito.genova.io.classmodel.XInterface;
import no.esito.genova.io.classmodel.XMethod;
import no.esito.genova.io.classmodel.XObject;
import no.esito.genova.io.classmodel.XParameter;
import no.esito.genova.io.classmodel.XRealization;
import no.esito.genova.model.classmodel.QAssociation;
import no.esito.genova.model.classmodel.QAttribute;
import no.esito.genova.model.classmodel.QClass;
import no.esito.genova.model.classmodel.QConverter;
import no.esito.genova.model.classmodel.QEnumerator;
import no.esito.genova.model.classmodel.QGeneralization;
import no.esito.genova.model.classmodel.QGroup;
import no.esito.genova.model.classmodel.QInterface;
import no.esito.genova.model.classmodel.QMethod;
import no.esito.genova.model.classmodel.QParameter;
import no.esito.genova.model.classmodel.QRealization;
import no.esito.genova.model.classmodel.QUserType;
import no.esito.genova.model.core.QObject;

public enum XController {
    Association,
    Attribute,
    Class,
    Converter,
    Domain,
    Enumerator,
    Generalization,
    Group,
    Interface,
    Member,
    Method,
    Parameter,
    Realization;

    public XObject create(XAbstract parent, QObject go) {
        switch (this) {
            case Association:
                return new XAssociation((QAssociation) go,parent);
            case Attribute:
                return new XAttribute((QAttribute) go,parent);
            case Class:
                return new XClass((QClass) go,parent);
            case Converter:
                return new XConverter((QConverter) go,parent);
            case Domain:
                return new XUserType((QUserType) go,parent);
            case Enumerator:
                return new XEnumerator((QEnumerator) go,parent);
            case Generalization:
                return new XGeneralization((QGeneralization) go,parent);
            case Group:
                return new XGroup((QGroup) go,parent);
            case Interface:
                return new XInterface((QInterface) go,parent);
            case Parameter:
                return new XParameter((QParameter) go,parent);
            case Realization:
                return new XRealization((QRealization) go,parent);
            case Method:
                return new XMethod((QMethod) go,parent);
        }
        return (XObject) getController(go,parent);

    }
    public static XAbstract getController(QObject go, XAbstract parent) {
        if (go instanceof QClass) {
            return new XClass((QClass) go, parent);
        } else if (go instanceof QConverter) {
            return new XEnumerator((QEnumerator) go, parent);
        } else if (go instanceof QGeneralization) {
            return new XGeneralization((QGeneralization) go, parent);
        } else if (go instanceof QUserType) {
            return new XUserType((QUserType) go, parent);
        } else if (go instanceof QGroup) {
            return new XGroup((QGroup) go, parent);
        } else if (go instanceof QInterface) {
            return new XInterface((QInterface) go, parent);
        } else if (go instanceof QParameter) {
            return new XParameter((QParameter) go, parent);
        } else if (go instanceof QRealization) {
            return new XRealization((QRealization) go, parent);
        } else if (go instanceof QAssociation) {
            return new XAssociation((QAssociation) go, parent);
        } else if (go instanceof QAttribute) {
            return new XAttribute((QAttribute) go, parent);
        }
        return null;
    }


}
