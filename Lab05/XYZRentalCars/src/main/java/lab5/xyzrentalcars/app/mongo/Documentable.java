package lab5.xyzrentalcars.app.mongo;

import lab5.xyzrentalcars.util.AuxMethods;
import org.bson.Document;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public abstract class Documentable {
    private Documentable instance;

    protected void setInstance(Documentable instance) {
        this.instance = instance;
    }

    public Document toMongoDocument() {
        Document doc = new Document();
        for (Field f : instance.getClass().getDeclaredFields()) {
            Method get = null;
            try {
                get = instance.getClass().getMethod("get" + AuxMethods.capitalize(f.getName()));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Object value = null;
            try {
                value = get.invoke(instance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (f.getName().equalsIgnoreCase("id")
                    || Objects.isNull(value))
                continue;

            if (value instanceof Documentable) {
                try {
                    doc.append(f.getName(), ((Documentable) value).toMongoDocument(f.getName()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (f.getType().isEnum()) {
                doc.append(f.getName(), ((Enum) value).name());
            } else if (f.getType().isPrimitive() || f.getType().equals(String.class)) {
                doc.append(f.getName(), value);
            }
        }
        return doc;
    }

    private Document toMongoDocument(String prefix) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Document doc = new Document();
        for (Field f : instance.getClass().getDeclaredFields()) {
            Method get = instance.getClass().getMethod("get" + AuxMethods.capitalize(f.getName()));
            Object value = get.invoke(instance);
            if (f.getName().equalsIgnoreCase("id")
                    || Objects.isNull(value))
                continue;

            if (value instanceof Documentable) {
                Documentable docAux = ((Documentable) get.getDefaultValue());
                doc.append(prefix + "_" + f.getName(), ((Documentable) value).toMongoDocument(f.getName()));
            } else if (f.getType().isEnum()) {
                Enum enumAux = ((Enum) get.getDefaultValue());
                doc.append(prefix + "_" + f.getName(), ((Enum) value).name());
            } else if (f.getType().isPrimitive() || f.getType().equals(String.class)) {
                doc.append(prefix + "_" + f.getName(), value);
            }
        }
        return doc;
    }
}
