Graphics 1280,1024,0,2
UebersichtB=LoadImage (".\Bilder\ÜbersichtK1.jpg")
UebersichtB2=LoadImage (".\Bilder\ÜbersichtK2.jpg")
UebersichtB3=LoadImage (".\Bilder\ÜbersichtK3.jpg")
UebersichtB4=LoadImage (".\Bilder\ÜbersichtK4.jpg")
UebersichtB5=LoadImage (".\Bilder\ÜbersichtK5.jpg")
UebersichtB6=LoadImage (".\Bilder\ÜbersichtK6.jpg")
UebersichtB7=LoadImage (".\Bilder\ÜbersichtK7.jpg")
UebersichtB8=LoadImage (".\Bilder\ÜbersichtK8.jpg")
UebersichtB9=LoadImage (".\Bilder\ÜbersichtK9.jpg")
UebersichtB10=LoadImage (".\Bilder\ÜbersichtK10.jpg")
UebersichtB11=LoadImage (".\Bilder\ÜbersichtK11.jpg")
UebersichtB12=LoadImage (".\Bilder\ÜbersichtK12.jpg")
UebersichtB13=LoadImage (".\Bilder\ÜbersichtK13.jpg")
UebersichtB14=LoadImage (".\Bilder\ÜbersichtK14.jpg")
UebersichtB15=LoadImage (".\Bilder\ÜbersichtK15.jpg")
UebersichtB16=LoadImage (".\Bilder\ÜbersichtK16.jpg")
UebersichtB17=LoadImage (".\Bilder\ÜbersichtK17.jpg")
UebersichtB18=LoadImage (".\Bilder\ÜbersichtK18.jpg")
UebersichtB19=LoadImage (".\Bilder\ÜbersichtK19.jpg")
UebersichtB20=LoadImage (".\Bilder\ÜbersichtK20.jpg")
UebersichtB21=LoadImage (".\Bilder\ÜbersichtK21.jpg")


Dim TB(20)
For i=0 To 20
ghjkk=ghjkk+1
UebersichtB=LoadImage (".\Bilder\ÜbersichtK"+ghjkk+".jpg")
DrawImage UebersichtB,0,0
NZ=NZ+1
TB(i)=CreateImage (520,48)
SetBuffer ImageBuffer (TB(i))

CopyRect 380,ghhjjhkf,520,48,0,0 ,FrontBuffer(),ImageBuffer(TB(i))
SetBuffer FrontBuffer()
SaveImage (TB(i),".\Bilder\Übersicht"+NZ+"b.bmp")
CopyFile quellpfad$, zielpfad$
ghhjjhkf=ghhjjhkf+48
Next




























