# e(fx)clipse

## Links

- https://www.eclipsecon.org/europe2017/session/developing-e4-application-efxclipse
    - http://www.bestsolution.at/de/
    - https://github.com/tomsontom
    - https://tomsondev.bestsolution.at/
- https://blog.codecentric.de/en/2015/02/swt-javafx-migration-eclipse-rcp-cookbook/
- http://www.eclipse.org/efxclipse/index.html
- http://wiki.eclipse.org/Efxclipse

## Tutorial Notes

- `Stage` is same as `Shell` or `Window`
- similar to Swing, add child component to parent
- Single Abstract Method Type -> Lambda
- scene based, not direct paint: no paint listeners (drawed by shader programm: DirectX/OpenGL)
- data binding directly build in
- JavaFX instead of SWT
    - JavaFX in SWT works
    - SWT in JavaFX does not work
    - Acessabiity: Tabbing into FX -> cant tab out
    - They wrote an SWT 80 % implementation which uses JavaFX
    - NatTable works
- e4 & JavaFx will got to POM first to be IDE agnostic
- Must have a perspective (at least one)

```
[Boot Classloade]
 ^
 |
[Ext Classloader] (here is JavaFX)
 ^
 |
[App Classloader]
 ^
 |
[Bundle Classloader] (in Equinox the parent is Boot CL, so -Dorg.osgi.framework.bundle.parent=ext is needed)
```

- Bei SWT wird nicht mehr viel neues passieren (Update der MFC Libs)
- Handles freigeben.