import Hero from "./atoms/Hero";
import Services from "./atoms/Services";
import Stats from "./atoms/Stats";
import Testimonials from "./atoms/Testimonials";
import Footer from "../fragments/Footer";

const Home = () => {
    return(
    <div className="hero">
        <div className="hero-body">
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <Hero />
                        <Services />
                        <Stats />
                        <Testimonials />
                        <Footer />
                    </div>
                </div>
            </div>
        </div>
    </div>
    )}

export default Home;