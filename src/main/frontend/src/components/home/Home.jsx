import Hero from "./atoms/Hero";
import Services from "./atoms/Services";
import Stats from "./atoms/Stats";
import Testimonials from "./atoms/Testimonials";
import Footer from "../fragments/Footer";

const Home = () => {
    return(
            <div className="main">
                        <Hero />
                        <Services />
                        <Stats />
                        <Testimonials />
                        <Footer />
    </div>
    )}

export default Home;