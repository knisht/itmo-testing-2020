import { mount } from '@vue/test-utils'
import TopMenu from "@/components/TopMenu.vue";


describe('Top Menu tests', () => {
    test('basic', () => {
        const wrapper = mount(TopMenu, {
            propsData: {
                links: []
            }
        });

        expect(wrapper.findAll('.topnav a')).toHaveLength(0)
    });

    test('two links', () => {
        const wrapper = mount(TopMenu, {
            propsData: {
                links: [{ link: "", text: "abc"}, { link: "", text: "def"}]
            }
        });

        expect(wrapper.findAll('.topnav a')).toHaveLength(2)
        expect(wrapper.findAll('.topnav a').at(0).text()).toBe("abc")
    });
})


