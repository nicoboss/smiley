Graphics 1280,1024,0,2
UebersichtB=LoadImage (".\Bilder\�bersichtK1.jpg")
UebersichtB2=LoadImage (".\Bilder\�bersichtK2.jpg")
UebersichtB3=LoadImage (".\Bilder\�bersichtK3.jpg")
UebersichtB4=LoadImage (".\Bilder\�bersichtK4.jpg")
UebersichtB5=LoadImage (".\Bilder\�bersichtK5.jpg")
UebersichtB6=LoadImage (".\Bilder\�bersichtK6.jpg")
UebersichtB7=LoadImage (".\Bilder\�bersichtK7.jpg")
UebersichtB8=LoadImage (".\Bilder\�bersichtK8.jpg")
UebersichtB9=LoadImage (".\Bilder\�bersichtK9.jpg")
UebersichtB10=LoadImage (".\Bilder\�bersichtK10.jpg")
UebersichtB11=LoadImage (".\Bilder\�bersichtK11.jpg")
UebersichtB12=LoadImage (".\Bilder\�bersichtK12.jpg")
UebersichtB13=LoadImage (".\Bilder\�bersichtK13.jpg")
UebersichtB14=LoadImage (".\Bilder\�bersichtK14.jpg")
UebersichtB15=LoadImage (".\Bilder\�bersichtK15.jpg")
UebersichtB16=LoadImage (".\Bilder\�bersichtK16.jpg")
UebersichtB17=LoadImage (".\Bilder\�bersichtK17.jpg")
UebersichtB18=LoadImage (".\Bilder\�bersichtK18.jpg")
UebersichtB19=LoadImage (".\Bilder\�bersichtK19.jpg")
UebersichtB20=LoadImage (".\Bilder\�bersichtK20.jpg")
UebersichtB21=LoadImage (".\Bilder\�bersichtK21.jpg")


Dim TB(20)
For i=0 To 20
ghjkk=ghjkk+1
UebersichtB=LoadImage (".\Bilder\�bersichtK"+ghjkk+".jpg")
DrawImage UebersichtB,0,0
NZ=NZ+1
TB(i)=CreateImage (520,48)
SetBuffer ImageBuffer (TB(i))

CopyRect 380,ghhjjhkf,520,48,0,0 ,FrontBuffer(),ImageBuffer(TB(i))
SetBuffer FrontBuffer()
SaveImage (TB(i),".\Bilder\�bersicht"+NZ+"b.bmp")
CopyFile quellpfad$, zielpfad$
ghhjjhkf=ghhjjhkf+48
Next




























