# Elevator_System

System odpowiadajacy za obsługe wind w budynku.

Istnieją 2 najważniejsze części systemu:
 - Reprezentacja windy (folder: Elevator)
 - System zarządzania windami (folder: ElevatorMenagament)
 
Aby skorzystać z systemu nalezy uruchomić plik objekt Main, który pozwoli przeprowadzić samodzielna symulację systemu windowego w budynku. Pozwala on wybrac za pośrednictwem terminala ilość wind
oraz pięter w budynku a następnie daje możliwośc tworzenia zapytań pickup -> wzywania windy z dowolnego piętra,
update -> pozwalającego na zmodyfikowanie miejjsca i kierunku windy / brzmi teleportacja windy :)  /,
step() -> odpalającego jeden krok symulacji (przejazd o 1 piątro lub odebranie/wypuszczenie pasażerów na danym piętrze)



Reprezentacja windy składa się z klasy Elevator oraz traita ElevatorApi służącego
za interface za pomocą którego pozostała część systemu będzie komunikować się z instancjami tej klasy.
1. ElevatorApi: definiuje podstawowe Api do obsługi windy, umożliwiając takie rzeczy jak:
otrzymanie informacji o id windy, piętrze, na którym się znajduje, czy kierunku, w którym winda jedzie.
Ponadto za jego pośrednictwem ElevatorSystem oraz Observer komunikuje sie z windami.
2. Elevator: klasa odpowiadająca za logikę działania windy w systemie, korzysta z Enuma: Direction, mogącego przyjmować 
wartośći: UP, STILL, DOWN, mówiącego nam w jakim kierunku winda się porusza. Ważnym nowym składnikiem jest też case klasa Pickup.
Odpowiada ona za zarządanie windy z konkretnego piętra i w konkretnym kierunku. Z powodów czysto symulacyjych zawarłem tam rownież konkretne piętro na które użytkownik windy będzie chciał jechać,
aby po odebraniu mieszkańca z piętra można było zasymulowac jego wybór piętra z środka windy. Jest to
wazne poneiważ w moim podejsciu piętra wybrane z środka windy mają wiekszy priorytet niz wezwania z zewnątrz
   (z pięter).

System zarzadzania windami skłąda się z głównego systemu: ElevatorSystem który odpowiada za logikę całości systemu. Przyjmuje on wezwania windy z pięter
i przeprowadza kroki symulacji, aktualizujac stany wind i szukajac najlepszej windy do przyjęcia wezwania.
Uzyłem wzorca Obserwator do przyjmowania wiadomosci z windy, ponieważ założylem, że jeżeli winda zmieni swój docelowy keirunek,
w skótek np: będącego wewnątrz człowieka lub wezwania na drodze danej windy powinna ona powiadomić o tym że nie dotrze do swojego celu.
Za to odpowiada klasa Obserwator która przechowuje liste wind oraz wezwań i aktualizuje je na podstawie informacji otrzymanych od wind jak i Elevator Symulatora.
Z tej listy nastepnie korzyta ElevatorSystem do przeprowadzania kroków symulacji.

W packegu test w klasie ElevatorTests znajdują się podstawowe testy sprawdzajaće działanie windy

Potencjalne ulepszenia:
- można by zastosować inna technikę wyboru najoptymalniejszej windy dla danego wezwania
- logiczne wydaje sie dodanie opóźnienia czasowego dla odbioru pasażerów z pięter względem przejechania przez winde 1 piętra.
- można by zastosowac więcej testów dla podneisienia bezpieczeństwa
